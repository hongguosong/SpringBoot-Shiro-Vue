<template>
  <div id="button">
      <h2>Button 按钮</h2>
      <h5>常用的操作按钮</h5>
      <br/>
      <br/>
      <br/>
      <h2>基础用法</h2>
      <h5>基础的按钮用法</h5>
      <div>
          <el-badge :value="age">
            <el-button @click="getData">默认按钮</el-button>
          </el-badge>
          <el-button type="primary">主要按钮</el-button>
          <el-button type="success">成功按钮</el-button>
          <el-button type="info" disabled>信息按钮</el-button>
          <el-button type="warning">警告按钮</el-button>
          <el-button type="danger">危险按钮</el-button>
      </div>
      <br/>
      <div>
          <el-button plain>朴素按钮</el-button>
          <el-button type="primary" plain>主要按钮</el-button>
          <el-button type="success" plain>成功按钮</el-button>
          <el-button type="info" plain disabled>信息按钮</el-button>
          <el-button type="warning" plain>警告按钮</el-button>
          <el-button type="danger" plain>危险按钮</el-button>
      </div>
      <br/>
      <div>
          <el-button round>朴素按钮</el-button>
          <el-button type="primary" round>主要按钮</el-button>
          <el-button type="success" round>成功按钮</el-button>
          <el-button type="info" round disabled>信息按钮</el-button>
          <el-button type="warning" round>警告按钮</el-button>
          <el-button type="danger" round>危险按钮</el-button>
      </div>
      <br/>
      <br/>
      <br/>
      <h2>文字按钮</h2>
      <div>
          <el-button type="text">文字按钮</el-button>
          <el-button type="text" disabled>文字按钮</el-button>
      </div>
      <br/>
      <br/>
      <br/>
      <h2>图标按钮</h2>
      <div>
          <el-button type="primary" icon="el-icon-edit"></el-button>
          <el-button type="primary" icon="el-icon-share" disabled></el-button>
          <el-button type="primary" icon="el-icon-delete"></el-button>
          <el-button type="primary" icon="el-icon-search">搜索</el-button>
          <el-button type="primary">上传<i class="el-icon-upload el-icon-right"></i></el-button>
      </div>
      <br/>
      <br/>
      <br/>
      <h2>按钮组</h2>
      <div>
         <el-button-group>
            <el-button type="success" icon="el-icon-arrow-left">上一页</el-button>
            <el-button type="success">下一页<i class="el-icon-arrow-right el-icon-right"></i></el-button>
          </el-button-group>
          <el-button-group>
            <el-button type="primary" icon="el-icon-edit"></el-button>
            <el-button type="primary" icon="el-icon-share"></el-button>
            <el-button type="primary" icon="el-icon-delete"></el-button>
            <el-button type="primary" icon="el-icon-search">搜索</el-button>
            <el-button type="primary">上传<i class="el-icon-upload el-icon-right"></i></el-button>
          </el-button-group>
      </div>

      <br/>
      <br/>
      <br/>
      <h2>加载中</h2>
      <div>
         <el-button-group>
            <el-button type="success" :loading="true">加载中</el-button>
          </el-button-group>
      </div>

      <br/>
      <br/>
      <br/>
      <h2>不同尺寸按钮</h2>
      <div>
        <el-button type="success">默认按钮</el-button>
        <el-button type="success" size="medium">中等按钮</el-button>
        <el-button type="success" size="small">小型按钮</el-button>
        <el-button type="success" size="mini">超小按钮</el-button>
      </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      age: '0'
    }
  },
  methods: {
    getData () {
      /* this.axios.get('http://localhost:8089/JSPYUFA/hello').then((response) => {
        console.log(response.data)
      }) */
      this.$jsonp('http://localhost:8089/JSPYUFA/hello', {
        name: 'zhangsan',
        type: 6
      }).then((response) => {
        // var me = JSON.parse(response)
        this.age = response.id
      }).catch(err => {
        console.log(err)
      })
    }
  }
}
</script>
