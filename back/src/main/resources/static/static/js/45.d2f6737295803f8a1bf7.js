webpackJsonp([45],{pTuF:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var o={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"notification"}},[n("el-button",{attrs:{plain:""},on:{click:t.open}},[t._v("可自动关闭")]),t._v(" "),n("el-button",{attrs:{plain:""},on:{click:t.open2}},[t._v("不会自动关闭")]),t._v(" "),n("el-button",{attrs:{plain:""},on:{click:t.open3}},[t._v("成功")])],1)},staticRenderFns:[]},i=n("/Xao")({methods:{open:function(){var t=this.$createElement;this.$notify({title:"标题名称",message:t("i",{style:"color: teal"},"是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案")})},open2:function(){this.$notify({title:"提示",message:"这是一条不会自动关闭的消息",duration:0,position:"bottom-right"})},open3:function(){this.$notify({title:"成功",message:"这是一条成功消息",type:"success",offset:400,showClose:!1})}}},o,!1,null,null,null);e.default=i.exports}});