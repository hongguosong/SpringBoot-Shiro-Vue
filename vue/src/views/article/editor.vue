<template>
  <div class="article_editor">
    <el-input v-model="title" placeholder="请输入文章标题" style="margin-bottom: 10px;"></el-input>
    <vue-ueditor-wrap ref="ueditor" v-model="content" :destroy="false" :config="config" @ready="ready" style="z-index: 1999"></vue-ueditor-wrap>
    <div style="margin-top: 5px; float: right">
      <el-button type="primary" @click="submit()" size="mini">submit</el-button>
      <el-button type="info" @click="clear()" size="mini">clear</el-button>
    </div>
  </div>
</template>

<script>
import VueUeditorWrap from 'vue-ueditor-wrap' // ES6 Module
import { mapGetters } from 'vuex'
export default {
  name: 'editor',
  components: {
    VueUeditorWrap
  },
  data () {
    return {
      title: '',
      content: '',
      config: {
        // 全屏时距离顶部距离
        topOffset: 0,
        enableAutoSave: true,
        // 编辑器不自动被内容撑高
        autoHeightEnabled: true,
        // 初始容器高度
        initialFrameHeight: 240,
        // 初始容器宽度
        initialFrameWidth: '100%',
        // 上传文件接口（这个地址是我为了方便各位体验文件上传功能搭建的临时接口，请勿在生产环境使用！！！）
        // serverUrl: 'http://35.201.165.105:8000/controller.php'
        serverUrl: this.$serverURL + '/sys/ueditor/exec'
        // UEditor 资源文件的存放路径，如果你使用的是 vue-cli 生成的项目，通常不需要设置该选项，vue-ueditor-wrap 会自动处理常见的情况，如果需要特殊配置，参考下方的常见问题2
        // UEDITOR_HOME_URL: '/static/UEditor/'
        // 配合最新编译的资源文件，你可以实现添加自定义Request Headers,详情https://github.com/HaoChuan9421/ueditor/commits/dev-1.4.3.3
        // headers: {
        //   access_token: '37e7c9e3fda54cca94b8c88a4b5ddbf3'
        // }
      }
    }
  },
  computed: {
    ...mapGetters([
      'nickname'
    ])
  },
  methods: {
    ready (editorInstance) {
      console.log(`实例${editorInstance.key}已经初始化:`, editorInstance)
      editorInstance.addListener('fullscreenchanged', function () {

      })
      // this.msg = localStorage.getItem("uData")
    },
    submit () {
      this.api({
        url: '/article/addArticle',
        method: 'post',
        data: {
          author: this.nickname,
          title: this.title,
          content: this.content
        }
      }).then(() => {
        this.$message.success('文章添加成功')
      })
    },
    clear () {
      this.title = ''
      this.content = ''
    }
  }
}
</script>

<style scoped>
  .article_editor .label{
    font-size: 12px;
    font-weight: bold;
    font-style: italic;
    margin: 5px;
  }
</style>
