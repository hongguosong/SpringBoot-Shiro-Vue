<template>
  <div id="notification">
    <el-button plain @click="open">可自动关闭</el-button>
    <el-button plain @click="open2">不会自动关闭</el-button>
    <el-button plain @click="open3">成功</el-button>
  </div>
</template>

<script>
export default {
  methods: {
    open () {
      const h = this.$createElement
      this.$notify({
        title: '标题名称',
        message: h('i', { style: 'color: teal' }, '是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案这是提示文案')
      })
    },
    open2 () {
      this.$notify({
        title: '提示',
        message: '这是一条不会自动关闭的消息',
        duration: 0,
        position: 'bottom-right'

      })
    },
    open3 () {
      this.$notify({
        title: '成功',
        message: '这是一条成功消息',
        type: 'success',
        offset: 400,
        showClose: false
      })
    }
  }
}
</script>
