<template>
    <div>
        <text-document v-bind.sync="post">Click</text-document>
    </div>
</template>

<script>
import textDocument from './text-document'
export default {
  components: {
    'text-document': textDocument
  },
  data () {
    return {
      post: {
        title: 'hg',
        text: '你好'
      }
    }
  }
}
</script>
