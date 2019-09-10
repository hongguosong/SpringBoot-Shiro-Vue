<template>
  <div id="elupload">
    <el-upload
      class="avatar-uploader"
      :action="action"
      :show-file-list="false"
      :on-success="handleAvatarSuccess"
      :before-upload="beforeAvatarUpload">
      <img v-if="imageUrl" :src="imageUrl" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
    <el-input
      type="textarea"
      :rows="3"
      placeholder="请输入图片描述内容"
      v-model="content"
      style="width: 500px;">
    </el-input>
    <div style="margin-top: 5px;">
      <el-button type="primary" size="mini" @click="submit">提交</el-button>
      <el-button type="info" size="mini">取消</el-button>
    </div>

  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'upload',
  data () {
    return {
      imageUrl: '',
      content: ''
    }
  },
  computed: {
    action: function () {
      return this.$serverURL + '/sys/ueditor/exec?action=uploadimage'
    },
    ...mapGetters([
      'nickname'
    ])
  },
  methods: {
    handleAvatarSuccess (res, file) {
      this.imageUrl = this.$serverURL + res.url
      console.log(this.imageUrl)
    },
    beforeAvatarUpload (file) {
      // const isJPG = file.type === 'image/jpeg';
      // const isLt2M = file.size / 1024 / 1024 < 2;
      //
      // if (!isJPG) {
      //   this.$message.error('上传头像图片只能是 JPG 格式!');
      // }
      // if (!isLt2M) {
      //   this.$message.error('上传头像图片大小不能超过 2MB!');
      // }
      // return isJPG && isLt2M;
    },
    submit () {
      if (this.imageUrl !== '') {
        this.api({
          url: '/picture/addPicture',
          method: 'post',
          data: {
            imgurl: this.imageUrl,
            content: this.content,
            author: this.nickname
          }
        }).then(data => {
          this.$message.success('上传图片成功')
        })
      } else {
        this.$message.error('清先上传图像')
      }
    }
  }
}
</script>

<style>
  /*.avatar-uploader {*/
    /*width: 178px;*/
    /*height: 178px;*/
    /*display: inline-block;*/
  /*}*/
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    /*width: 178px;*/
    /*height: 178px;*/
    display: block;
  }
</style>
