<template>
  <div>
    <h3 v-if="post.isPublished">{{post.title | capitalize}} {{post.likes}} {{post.commentIds}}</h3>
    <h6>
      {{post.author.name}} {{post.author.title}}
      <button @click="$emit('enlarge-text', 0.1)">
        Enlarge text
      </button>
    </h6>
  </div>
</template>

<script>
export default {
  // props: {
  //   title: String,
  //   likes: Number,
  //   isPublished: Boolean,
  //   commentIds: Array,
  //   author: Object
  // }
  props: ['post'],
  filters: {
    capitalize: function (value) {
      if (!value) return ''
      value = value.toString()
      return value.charAt(0).toUpperCase() + value.slice(1)
    }
  }
}
</script>
