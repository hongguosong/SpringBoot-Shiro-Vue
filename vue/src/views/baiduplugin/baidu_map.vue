<template>
    <div id="baidu_map">
      hello baidu map
      <baidu-map class="bm-view" :center="center" :zoom="zoom" @ready="handler" :scroll-wheel-zoom="true">
        <bm-scale anchor="BMAP_ANCHOR_BOTTOM_LEFT" v-if="scale"></bm-scale>
        <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_LEFT"></bm-map-type>
        <bm-overview-map anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :isOpen="true"></bm-overview-map>
        <bm-geolocation anchor="BMAP_ANCHOR_TOP_RIGHT" :showAddressBar="true" :autoLocation="true"></bm-geolocation>
      </baidu-map>
    </div>
</template>

<script>
export default {
  name: 'baidu_map',
  data () {
    return {
      center: { lng: 0, lat: 0 },
      zoom: 3,
      scale: false
    }
  },
  methods: {
    handler ({ Bmap, map }) {
      console.log(Bmap, map)
      this.center.lng = 123.4
      this.center.lat = 34.7
      this.zoom = 14
      this.center = '太仓'
    }
  }
}
</script>

<style scoped>
  .bm-view {
    width: 100%;
    height: 500px;
  }
</style>
