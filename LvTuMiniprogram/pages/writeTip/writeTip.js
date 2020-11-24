//logs.js
const { $Toast } = require('../../dist/base/index');
var util = require('../../utils/util.js');
var app = getApp();
Page({
  data: {
    tips: [],
  },

  submitTip : function(e){
    console.log(e.detail.value.strategyContent);
    console.log(e.detail.value.strategyName);
    console.log(app.globalData.userInfo.userId);
    var tips = util.getData(app.globalData.url+'releaseStrategy',
    {"strategyContent":e.detail.value.strategyContent,
     "strategyName":e.detail.value.strategyName,
     "userId":app.globalData.userInfo.userId},'POST');
    console.log("loaddata");
    var that = this;
    tips.then(function(res){
      console.log("success");
     // console.log(tips);
    })
   

  }
})