// pages/lvtureupdate/lvtureupdate.js

var app = getApp()//获取url
Page({
  data: {
    userId:'',
    matName:'',
    matContent:'',
    
  },

  formSubmit: function (e) {

    this.upload(e)
  },
  /**
   * 问题：
   *一张图片上传
  */
  upload: function (e) {
   /* var that = this
    wx.login({
      success: function(res) {
    wx.request({
      url: app.globalData.url+'onlogin',          //本地调试，是获取不到code的，所以要实现，还是得传服务
      data: {
        "code": res.code
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success: function (res) {
       console.log(res.data.openid)
       var OD=res.data.openid  以上内容为获取用户openid，可以不要*/
  
    wx.request({ 
        header: {
          'content-type': 'application/x-www-form-urlencoded'
        }, 
        url: app.globalData.url+'releaseMatch',  
        data:{
          'matContent': e.detail.value.matContent,   
          'matName': e.detail.value.matName,
          // "oppidA":OD
          'userID':OD
        },  
        method: 'POST', 
        success: function (res) {          if (res) {
          wx.showToast({
            title: '已提交至管理员审核，请耐心等待！',
            duration: 3000
          });
          setTimeout(() => {
            wx.switchTab({
            url: '../notify/notify',
            })
          }, 1000);//发完贴1秒自动跳转到帖子列表页
        
        }} 
      }
    )
  
}})

