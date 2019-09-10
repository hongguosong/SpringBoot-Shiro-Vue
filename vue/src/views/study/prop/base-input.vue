<template>
    <label>
        {{label}}
        <input
        v-bind="$attrs"
        v-bind:value="value"
        v-on="inputListeners"
        v-focus>
    </label>
</template>

<script>
export default {
  inheritAttrs: false,
  props: {
    label: {
      type: String,
      required: true
    },
    value: [String, Number]
  },
  created () {
    console.log(this.$attrs)
  },
  computed: {
    inputListeners: function () {
      var vm = this
      return Object.assign({},
        this.$listeners,
        {
          input: function (event) {
            vm.$emit('input', event.target.value)
          }
        })
    }
  },
  directives: {
    focus: {
      inserted: function (el) {
        el.focus()
      }
    }
  }
}
</script>
