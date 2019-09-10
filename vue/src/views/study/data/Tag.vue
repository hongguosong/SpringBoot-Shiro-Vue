<template>
  <div id="tag">
    <el-tag
      :key="tag.text"
      v-for="tag in dynamicTags"
      closable
      :type="tag.tp"
      :disable-transitions="false"
      @close="handleClose(tag)">
      {{tag.text}}
    </el-tag>
    <el-input
      class="input-new-tag"
      v-if="inputVisible"
      v-model="inputValue"
      ref="saveTagInput"
      size="small"
      @keyup.enter.native="handleInputConfirm"
      @blur="handleInputConfirm"
    >
    </el-input>
    <el-button v-else class="button-new-tag" size="small" @click="showInput">+ New Tag</el-button>
  </div>
</template>

<style>
.el-tag + .el-tag {
  margin-left: 10px;
}
.button-new-tag {
  margin-left: 10px;
  height: 32px;
  line-height: 30px;
  padding-top: 0;
  padding-bottom: 0;
}
.input-new-tag {
  width: 90px;
  margin-left: 10px;
  vertical-align: bottom;
}
</style>

<script>
export default {
  data () {
    return {
      dynamicTags: [
        { text: '标签一', tp: 'success' },
        { text: '标签二', tp: 'info' },
        { text: '标签三', tp: 'warning' }
      ],
      inputVisible: false,
      inputValue: '',
      colorA: [ 'success', 'info', 'warning', 'danger', 'primary' ]
    }
  },
  methods: {
    handleClose (tag) {
      this.dynamicTags.splice(this.dynamicTags.indexOf(tag), 1)
    },

    showInput () {
      this.inputVisible = true
      this.$nextTick(_ => {
        this.$refs.saveTagInput.$refs.input.focus()
      })
    },
    handleInputConfirm () {
      let inputValue = this.inputValue
      let a = { text: inputValue, tp: '' }
      a.tp = this.getColorA()
      if (inputValue) {
        this.dynamicTags.push(a)
      }
      this.inputVisible = false
      this.inputValue = ''
    },
    getColorA () {
      let w = Math.round(Math.random() * 5 - 1)
      if (w >= 0 && w < 5) {
        return this.colorA[w]
      }
      return this.colorA[0]
    }
  }
}
</script>
