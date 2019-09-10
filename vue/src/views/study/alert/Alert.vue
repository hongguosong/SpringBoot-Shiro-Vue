<template>
  <div id="alert">
    <div class="item">
      <el-alert title="成功提示的文案" type="success" show-icon center
        description="这是一句绕口令：黑灰化肥会挥发发灰黑化肥挥发；灰黑化肥会挥发发黑灰化肥发挥。 黑灰化肥会挥发发灰黑化肥黑灰挥发化为灰……">

      </el-alert>
      <el-alert title="消息提示的文案" type="info" show-icon center></el-alert>
      <el-alert title="警告提示的文案" type="warning" show-icon></el-alert>
      <el-alert title="错误提示的文案" type="error" show-icon></el-alert>
    </div>

    <div class="item">
      <el-alert title=“不可关闭的按钮” type="success" :closable="false"></el-alert>
      <el-alert title="自定义的close-text" type="info" close-text="知道了"></el-alert>
      <el-alert title="设置了回调的 alert" type="warning" @close="hello"></el-alert>
    </div>

    <el-button type="primary" @click="openFullScreen" v-loading.fullscreen.lock="fullscreenLoading">指令方式</el-button>
    <el-button type="primary" @click="openFullScreen2">服务方式</el-button>
  </div>
</template>

<script>
export default {
  data () {
    return {
      fullscreenLoading: false
    }
  },
  methods: {
    hello () {
      alert('Hello world!')
    },
    openFullScreen () {
      this.fullscreenLoading = true
      setTimeout(() => {
        this.fullscreenLoading = false
      }, 2000)
    },
    openFullScreen2 () {
      const loading = this.$loading({
        lock: true,
        text: 'Loading',
        spinner: 'el-icon-loading',
        background: 'rgba(0,0,0,0.8)'
      })
      setTimeout(() => {
        loading.close()
      }, 2000)
    }
  }
}
</script>

<style>
  .item{
    padding: 20px;
    margin: 20px;

    width: 800px;
    border: 1px solid #eeeeee
  }

  .el-alert{
    margin-top: 20px;
  }
</style>
