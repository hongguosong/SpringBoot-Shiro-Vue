<template>
  <div>
    <h1 style="text-align: center;">{{title}}</h1>
    <el-row>
      <el-col :span="12" style="color: lightskyblue">作者: {{author}}</el-col>
      <el-col :span="12" style="text-align: right; font-style: italic">发表时间: {{updateTime}}</el-col>
    </el-row>
    <div v-html="content" style="padding: 10px;"></div>

    <div v-if="comments.length>0">评论:</div>
    <div v-for="(item, index) in comments" :key="item.commentId">
      <hr/>
      <div style="font-size: 11px; padding: 10px;">
        <span>{{index+1}}楼</span>
        <span style="color: blue">{{item.commentName}}</span>
        <span>{{item.commentCreateTime}}</span>
      </div>
      <div style="padding: 10px;">{{item.commentContent}}</div>
    </div>
    <hr v-if="comments.length>0"/>

    <div>
      <el-input v-model="input" placeholder="请输入评论..."></el-input>
      <div style="padding: 10px;">
        <el-button type="primary" size="mini" @click="commandHandler">添加评论</el-button>
        <el-button type="info" size="mini" @click="cancleHandler">取消</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
// import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
  name: 'show',
  props: ['id'],
  data () {
    return {
      article: '',
      author: '',
      title: '',
      content: '',
      updateTime: '',
      comments: [],

      input: ''
    }
  },
  computed: {
    // content () {
    //   return this.article.content
    // },
    ...mapGetters([
      'nickname'
    ]),
    selfId () {
      return this.id === ':id' ? localStorage.getItem('id') : this.id
    }
  },
  mounted () {
    this.getArticle()
  },
  methods: {
    cancleHandler () {
      this.input = ''
    },
    getArticle () {
      var that = this
      this.api({
        url: '/article/getArticleById?id=' + this.selfId,
        method: 'get'
      }).then(data => {
        this.article = data[0]
        this.author = data[0].author
        this.title = data[0].title
        this.content = data[0].content
        this.updateTime = data[0].updateTime
        this.comments = data[0].comments
        localStorage.setItem('id', that.selfId)
      })
    },
    commandHandler () {
      this.api({
        url: '/article/addComment',
        method: 'post',
        data: {
          articleId: this.selfId,
          name: this.nickname,
          content: this.input
        }
      }).then(data => {
        // if (data>0) {
        //   this.$message.success("评论成功")
        // }else{
        //   this.$message.success("评论失败")
        // }
        this.getArticle()
        this.input = ''
      })
    }
  }
}
</script>

<style scoped>

</style>
