<template>
  <div id="radio">

      <h2>基础用法</h2>
      <div>
          <el-radio disabled v-model="radio" label="1">备选项1</el-radio>
          <el-radio v-model="radio" label="2">备选项2</el-radio>
      </div>

      <br/>
      <br/>
      <br/>
      <h2>禁用状态</h2>
      <div>

            <el-radio disabled v-model="radio1" label="禁用">备选项1</el-radio>
            <el-radio disabled v-model="radio1" label="选中且禁用">备选项2</el-radio>

      </div>
      <br/>
      <br/>
      <br/>
      <h2>单选框组</h2>
      <div>
          <el-radio-group v-model="radio2">
            <el-radio v-model="radio2" border label="3">备选项1</el-radio>
            <el-radio v-model="radio2" label="6">备选项2</el-radio>
            <el-radio v-model="radio2" label="9">备选项2</el-radio>
          </el-radio-group>
      </div>

      <br/>
      <br/>
      <br/>
      <h2>单选框组</h2>
      <div>
          <el-radio-group v-model="radio3">
            <el-radio-button  label="上海">上海</el-radio-button>
            <el-radio-button  label="北京">北京</el-radio-button>
            <el-radio-button  label="广州">广州</el-radio-button>
            <el-radio-button  label="深圳">深圳</el-radio-button>
          </el-radio-group>
          <br/>
          <br/>
          <el-radio-group v-model="radio4" size="medium">
            <el-radio-button  label="上海">上海</el-radio-button>
            <el-radio-button  label="北京">北京</el-radio-button>
            <el-radio-button  label="广州">广州</el-radio-button>
            <el-radio-button  label="深圳">深圳</el-radio-button>
          </el-radio-group>
          <br/>
          <br/>
          <el-radio-group v-model="radio5" size="small">
            <el-radio-button  label="上海">上海</el-radio-button>
            <el-radio-button  label="北京">北京</el-radio-button>
            <el-radio-button  label="广州">广州</el-radio-button>
            <el-radio-button  label="深圳">深圳</el-radio-button>
          </el-radio-group>
          <br/>
          <br/>
          <el-radio-group v-model="radio6" disabled size="mini">
            <el-radio-button  label="上海">上海</el-radio-button>
            <el-radio-button  label="北京">北京</el-radio-button>
            <el-radio-button  label="广州">广州</el-radio-button>
            <el-radio-button  label="深圳">深圳</el-radio-button>
          </el-radio-group>
      </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      radio: '1',
      radio1: '选中且禁用',
      radio2: '3',
      radio3: '深圳',
      radio4: '深圳',
      radio5: '深圳',
      radio6: '深圳'
    }
  }
}
</script>
