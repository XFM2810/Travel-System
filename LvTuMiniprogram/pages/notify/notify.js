//logs.js
var util = require('../../utils/util.js')
var app = getApp();

Page({
  data: {
    navTab: ["发布结伴游", "参与结伴游", "修改结伴游"],
    currentNavtab: "1",
    title:"",
    writer:" ",
    time:"",
    number:"",
  },
  onLoad: function () {

  },
  switchTab: function(e){
    if(e.currentTarget.dataset.idx=='0'){
      wx.navigateTo({
      url: '../lvturelease/lvturelease',
    })}
    if(e.currentTarget.dataset.idx=='2'){
      wx.navigateTo({
      url: '../lvtureupdate/lvtureupdate',
    })}
  },

  onPullDownRefresh() {
    this.onShow();
    console.log("上拉刷新");
    },
    
  img:function()  //点图片跳转
  {
    wx.navigateTo({
      url: '../img/img'
    })
  },

  getUserInfo:function(e){
    console.log(e.detail.userInfo)
    wx.request({    
        url: app.globalData.url+'all',  
        data:{
          'writer': e.detail.userInfo.nickName,  
          'pic' : e.detail.userInfo.avatarUrl,
        method: 'POST',  
        header: {
          'content-type': 'application/json'
        },
        success:function(res) {  
          console.log('submit successs');  
        },  
        fail:function(res){  
            console.log('submit fail');  
        }
    }
  })
},
  formSubmit(e) {  //查找
        console.log(e.detail.value)
        wx.navigateTo({
          url: '../lvtufind/lvtufind?find='+e.detail.value.find,
          })
           
  },
  /**
   * 页面的初始数据
   */
  
  /**
   * 生命周期函数--监听页面加载
   */
   onLoad: function () {
        var that = this
        wx.request({
          url: app.globalData.url+'getMatchOfCity?city=武汉&currentPage=1&pageSize=5',
          headers: {
            'Content-Type': 'application/json'
          },
          success: function (res) {
            //将获取到的json数据，存在名字叫list的这个数组中
              console.log(res.data);
              that.setData(
              {
              list: res.data.data,
              //res代表success函数的事件对，data是固定的，list是数组
            })
          }
        })
      },
  tempData: function () {
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    var that = this
        wx.request({
          url: app.globalData.url+'getMatchOfCity?city=武汉&currentPage=1&pageSize=5',
          headers: {
            'Content-Type': 'application/json'
          },
          success: function (res) {
            //将获取到的json数据，存在名字叫list的这个数组中
              console.log(res.data);
              that.setData(
              {
              list: res.data.data,
              //res代表success函数的事件对，data是固定的，list是数组
            })
          }
        })
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */


  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
  
})
