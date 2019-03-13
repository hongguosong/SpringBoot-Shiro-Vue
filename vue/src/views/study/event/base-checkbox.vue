<template>
  <span>
    <input type="checkbox" v-bind:checked="checked" v-on:change="$emit('change', $event.target.checked)"/>
    <slot>{{checked}}</slot>
  </span>
</template>

<script>
  export default {
    name: 'base-checkbox',
    model: {
      prop: 'checked',
      event: 'change'
    },
    props: {
      checked: Boolean
    }
  }
</script>

<style scoped>

</style>
