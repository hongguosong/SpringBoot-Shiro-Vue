<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app',
  methods: {
    handler: function () {

    }
  },
  mounted () {
    // this.websocket.initWebSocket()
    document.addEventListener('mousewheel', this.handler, { passive: true })
  },
  beforeDestroy () {
    // this.websocket.close()
  }
}
</script>

<style lang="scss">
  @import '~normalize.css/normalize.css';// normalize.css 样式格式化
  @import './styles/index.scss'; // 全局自定义的css样式

  body {
    /*background: url('../src/images/paper.gif')*/
    background: #F5F5F5;
  }
</style>
