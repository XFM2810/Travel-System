//logs.js
var util = require('../../utils/util.js')
//var app = getApp()
Page({
  data: {
    motto: 'Hello World',
    userInfo: {}
  },
  //事件处理函数
  bindMyTip1: function() {
    wx.navigateTo({
      url: `../tipList/tipList?typeId=1`
    })
  },
  bindMyTip2: function() {
    wx.navigateTo({
      url: `../tipList/tipList?typeId=2`
    })
  },
  bindWriteTip: function() {
    wx.navigateTo({
      url: '../writeTip/writeTip'
    })
  },

  bindUserInfo:function(){
    wx.navigateTo({
      url: '../userInfo/userInfo',
    })
  },

  onLoad: function () {
    console.log('onLoad')
    var that = this
    //调用应用实例的方法获取全局数据
 //   app.getUserInfo(function(userInfo){
      //更新数据
  //    that.setData({
  //      userInfo:userInfo
   //   })
   // })
  }
})