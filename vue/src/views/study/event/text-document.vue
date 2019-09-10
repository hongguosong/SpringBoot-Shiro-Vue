<template>
    <div>
        <h1>{{title}}</h1>
        <h4>{{text}}</h4>
        <button @click="clickHere">
            <slot>change</slot>
        </button>
    </div>
</template>

<script>
export default {
  props: ['title', 'text'],
  methods: {
    clickHere: function () {
      this.$emit('update:title', 'newTitle')
    }
  }
}
</script>
