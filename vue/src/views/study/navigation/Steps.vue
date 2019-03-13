<template>
  <div id="steps">
    <el-steps :active="active" finish-status="success" align-center>
      <el-step title="步骤1" description="这是一段很长很长很长的描述性文字" icon="el-icon-edit"></el-step>
      <el-step title="步骤2" description="这是一段很长很长很长的描述性文字"></el-step>
      <el-step title="步骤3" description="这是一段很长很长很长的描述性文字"></el-step>
    </el-steps>
    <el-button @click="next" style="margin: 12px">下一步</el-button>

    <el-steps :active="active" simple finish-status="success">
      <el-step title="步骤1" description="这是一段很长很长很长的描述性文字" icon="el-icon-edit"></el-step>
      <el-step title="步骤2" description="这是一段很长很长很长的描述性文字"></el-step>
      <el-step title="步骤3" description="这是一段很长很长很长的描述性文字"></el-step>
    </el-steps>
  </div>
</template>

<script>
export default {
  data () {
    return {
      active: 0
    }
  },
  methods: {
    next () {
      if (this.active++ > 2) {
        this.active = 0
      }
    }
  }
}
</script>
