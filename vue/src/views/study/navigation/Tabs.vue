<template>
  <div id="tabs">
    <el-radio-group v-model="tabPosition" style="margin-bottom: 30px">
      <el-radio label="top">top</el-radio>
      <el-radio label="bottom">bottom</el-radio>
      <el-radio label="left">left</el-radio>
      <el-radio label="right">right</el-radio>
    </el-radio-group>
    <el-tabs v-model="activeName" @tab-click="handleClick" type="border-card" :tab-position="tabPosition">
      <el-tab-pane name="first">
      <span slot="label">
        <i class="el-icon-date"></i>
         用户管理
      </span>
        用户管理
      </el-tab-pane>
      <el-tab-pane label="配置管理" name="second">配置管理</el-tab-pane>
      <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>
      <el-tab-pane label="路径管理" name="fourth">路径管理</el-tab-pane>
    </el-tabs>
    <br/>

    <el-breadcrumb separator="/">
      <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/foo' }">活动管理</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/bar' }">活动列表</el-breadcrumb-item>
      <el-breadcrumb-item>活动详情</el-breadcrumb-item>
    </el-breadcrumb>
  </div>
</template>

<script>
export default {
  data () {
    return {
      activeName: 'second',
      tabPosition: 'top'
    }
  },
  methods: {
    handleClick (tab, event) {
      console.log(tab, event)
    }
  }
}
</script>

<style scoped>

#app .main-container {
  min-height: 100%;
  -webkit-transition: margin-left 0.28s;
  transition: margin-left 0.28s;
  margin-left: 90px;
  margin-top: 50px;
}
</style>
