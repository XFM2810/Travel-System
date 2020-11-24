//answer.js
var util = require('../../utils/util.js')
var app = getApp()
Page({
  data: {
    tip: {}
  },
  //事件处理函数
  toQuestion: function() {
    wx.navigateTo({
      url: '../question/question'
    })
  },
  onLoad: function (options) {
    console.log('onLoad')
    var that = this
    var strategyId = options.strategyId;
    console.log(options.strategyId);
    var tips = util.getData(app.globalData.url+'getStrategyInfo',{'strategyId':strategyId},'GET');
    console.log("loaddata");
    var that = this;
    tips.then(function(res){
     that.setData({
       tip:res,
     });
    console.log(res);
   })
   


  },
  writeAppraise: function(event){
    console.log(event.currentTarget.id)//攻略id
    var tips = util.getData(app.globalData.url+'getStrategyInfo',{'strategyId':strategyId},'GET');
    console.log("loaddata");
    var that = this;
    tips.then(function(res){
     that.setData({
       tip:res,
     });
    console.log(res);
    })
  },
  collection: function(event){
    console.log(event.currentTarget.id)//攻略id

    var tips = util.getData(app.globalData.url+'getStrategyInfo',{'strategyId':strategyId},'GET');
    console.log("loaddata");
    var that = this;
    tips.then(function(res){
     that.setData({
       tip:res,
     });
    console.log(res);
    })
  },

})
