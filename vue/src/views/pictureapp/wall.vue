<template>
  <div>
    <div style="width: 800px; margin: auto;">
      <el-carousel :interval="5000" type="card" height="200px">
        <el-carousel-item v-for="item in data" :key="item.id">
          <img :src="item.imgurl"/>
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="container">
      <el-card class="item" shadow="hover" :body-style="{ padding: '0px'}" v-for="item in data" :key="item.id">
        <div id="boxshadow">
          <a target="_blank" :href="item.imgurl">
            <img :src="item.imgurl" alt="wait" class="image">
          </a>
        </div>
        <div style="padding: 0px 5px;margin-top: 10px;">
          <p style="text-align: justify;">{{item.content}}</p>
          <div class="bottom clearfix">
            <span class="auth">{{ item.author }}</span>
            <span class="time">{{ item.createTime }}</span>
          </div>
        </div>
      </el-card>
      <!--<div style="width: 100px;height: 100px;overflow: auto">{{data[0].content}}</div>-->
    </div>
  </div>
</template>

<script>
export default {
  name: 'picture-wall',
  data () {
    return {
      data: []
    }
  },
  mounted () {
    let that = this
    this.api({
      url: '/picture/listPicture',
      method: 'post',
      data: {
        // author: this.nickname
      }
    }).then(data => {
      // this.$message.success('上传图片成功')
      for (let i = 0; i < data.list.length; i++) { that.data.push(data.list[i]) }
    })
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .container {
    text-align: center;
    width: 800px;
    margin: auto;
    column-count: 3;
    column-gap: 20px;
  }

  .item {
    break-inside: avoid;
    box-sizing: border-box;
    padding: 10px;
    margin-bottom: 10px;
  }

  .image {
    width: 100%;
    height: auto;
    display: block;
  }

  .bottom {
    font-size: 13px;
    margin-top: 5px;
    .auth {
      float: left;
      color: #66b1ff;
    }
    .time {
      color: #999;
      float: right;
    }
  }

  /*#boxshadow {*/
    /*position: relative;*/
    /*-moz-box-shadow: 1px 2px 4px rgba(0, 0, 0,0.5);*/
    /*-webkit-box-shadow: 1px 2px 4px rgba(0, 0, 0, .5);*/
    /*box-shadow: 1px 2px 4px rgba(0, 0, 0, .5);*/
    /*padding: 10px;*/
    /*background: white;*/
  /*}*/

  /* Make the image fit the box */
  /*#boxshadow img {*/
    /*width: 100%;*/
    /*border: 1px solid #8a4419;*/
    /*border-style: inset;*/
  /*}*/

  /*#boxshadow::after {*/
    /*<!--content: '';-->*/
    /*<!--position: absolute;-->*/
    /*<!--z-index: -1; !* hide shadow behind image *!-->*/
    /*<!-- -webkit-box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);-->*/
    /*<!-- -moz-box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);-->*/
    /*<!--box-shadow: 0 15px 20px rgba(0, 0, 0, 0.3);-->*/
    /*<!--width: 70%;-->*/
    /*<!--left: 15%; !* one half of the remaining 30% *!-->*/
    /*<!--height: 100px;-->*/
    /*<!--bottom: 0;-->*/
  /*}*/
</style>
