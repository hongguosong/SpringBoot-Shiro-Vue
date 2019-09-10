<template>
  <div id="message">
    <el-button :plain="true" @click="open">打开消息框</el-button>
    <el-button :plain="true" @click="openVn">VNode</el-button>

    <br/>
    <br/>

    <el-button :plain="true" @click="open2" @close="hello">成功</el-button>
    <el-button :plain="true" @click="open3">警告</el-button>
    <el-button :plain="true" @click="open">消息</el-button>
    <el-button :plain="true" @click="open4">错误</el-button>
    <el-button :plain="true" @click="openHTML">使用HTML片段</el-button>
  </div>
</template>

<script>
export default {
  methods: {
    open () {
      this.$message('这是 一条消息提示框')
    },
    open2 () {
      this.$message({
        message: '恭喜你，这是一条成功消息',
        type: 'success',
        showClose: true,
        duration: 0
      })
    },
    hello () {
      alert('关闭')
    },
    open3 () {
      this.$message({
        message: '警告哦，这是一条警告消息',
        type: 'warning',
        center: true
      })
    },
    open4 () {
      this.$message.error('错了哦，这是一条错误消息')
    },
    openHTML () {
      this.$message({
        dangerouslyUseHTMLString: true,
        message: '<strong>这是<i>HTML</i>片段</strong>',
        type: 'error'
      })
    },
    openVn () {
      const h = this.$createElement
      this.$message({
        message: h('p', null, [
          h('span', null, '内容可以是'),
          h('i', { style: 'color: teal' }, 'VNode')
        ])
      })
    }
  }
}
</script>
