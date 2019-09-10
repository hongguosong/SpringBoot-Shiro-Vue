<template>
    <div @click="cl">{{name}}</div>
</template>

<script>
export default {
  props: ['name'],
  methods: {
    cl: function () {
      this.name = 'hong'
    }
  }
}
</script>
