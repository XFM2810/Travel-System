//index.js

var util = require('../../utils/util.js')
var app = getApp()
Page({
  data: {
    tips: [],
  },
  //事件处理函数
  bindItemTap: function(event) {
    var strategyId = event.currentTarget.id;
    wx.navigateTo({
      url: `../tipDetail/tipDetail?strategyId=${strategyId}`,
    })
  },

  onLoad: function (options) {
    console.log('onLoad')
    var that = this
    var typeId = options.typeId;
    if(typeId == 1){//我的攻略
      this.getData(app.globalData.url+'getStrategyListOfUserRelease');
    }else if(typeId == 2){//我的收藏
      this.getData(app.globalData.url+'getStrategyListOfUserCollection');
    }
  },
  upper: function () {
    wx.showNavigationBarLoading()
    this.refresh();
    console.log("upper");
    setTimeout(function(){wx.hideNavigationBarLoading();wx.stopPullDownRefresh();}, 2000);
  },
  lower: function (e) {
    wx.showNavigationBarLoading();
    var that = this;
    setTimeout(function(){wx.hideNavigationBarLoading();that.nextLoad();}, 1000);
    console.log("lower")
  },
  //scroll: function (e) {
  //  console.log("scroll")
  //},


  getData: function(url){   
      var tips = util.getData(url,{'userId':app.globalData.userInfo.userId},'GET');
      console.log("loaddata");
      var that = this;
      tips.then(function(res){
        that.setData({
          tips:res,
        });
       // console.log(tips);
      })
  },
  refresh: function(){
    wx.showToast({
      title: '刷新中',
      icon: 'loading',
      duration: 3000
    });
    var feed = util.getData2();
    console.log("loaddata");
    var feed_data = feed.data;
    this.setData({
      feed:feed_data,
      feed_length: feed_data.length
    });
    setTimeout(function(){
      wx.showToast({
        title: '刷新成功',
        icon: 'success',
        duration: 2000
      })
    },3000)

  },

  //使用本地 fake 数据实现继续加载效果
  nextLoad: function(){
    wx.showToast({
      title: '加载中',
      icon: 'loading',
      duration: 4000
    })
    var next = util.getNext();
    console.log("continueload");
    var next_data = next.data;
    this.setData({
      feed: this.data.feed.concat(next_data),
      feed_length: this.data.feed_length + next_data.length
    });
    setTimeout(function(){
      wx.showToast({
        title: '加载成功',
        icon: 'success',
        duration: 2000
      })
    },3000)
  }


})
