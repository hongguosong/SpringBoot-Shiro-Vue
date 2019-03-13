<template>
  <div class="dashboard-container" id="container">
    <!--<a href="https://github.com/Heeexy/SpringBoot-Shiro-Vue" target="_blank"><img style="margin: 40px"-->
      <!--src="http://img.heeexy.com/github.png"></a>-->
  </div>
</template>
<script>
  import * as THREE from 'three'
  import TrackballControls from '@/api/TrackballControls.js'
  export default {
    name: 'dashboard',
    data() {
      return {
        container: null,
        camera: null,
        scene: null,
        renderer: null,
        pointLight: null,
        objects: [],
        materials: [],
        controls: null,
        width: window.innerWidth-54,
        height: window.innerHeight-54
      }
    },
    methods: {
      init: function () {
        this.container = document.getElementById('container');
        this.renderer = new THREE.WebGLRenderer({antialias: true});
        this.renderer.setSize(this.width, this.height);
        this.container.appendChild(this.renderer.domElement);

        this.camera = new THREE.PerspectiveCamera( 45, this.width / this.height, 1, 2000 );
        this.camera.position.set( 0, 200, 800 );
        this.scene = new THREE.Scene();

        //controls
        this.controls = new TrackballControls( this.camera, this.renderer.domElement );
        this.controls.rotateSpeed = 5.0;
        this.controls.zoomSpeed = 5;
        this.controls.panSpeed = 2;
        this.controls.noZoom = false;
        this.controls.noPan = false;
        this.controls.staticMoving = false;
        this.controls.dynamicDampingFactor = 0.3;

        //grid
        var helper = new THREE.GridHelper( 1000, 40, 0x303030, 0x303030 );
        helper.position.y = - 75;
        this.scene.add( helper );

        // Materials
        var texture = new THREE.Texture( this.generateTexture() );
        texture.needsUpdate = true;
        this.materials.push( new THREE.MeshLambertMaterial( { map: texture, transparent: true } ) );
        this.materials.push( new THREE.MeshLambertMaterial( { color: 0xdddddd } ) );
        this.materials.push( new THREE.MeshPhongMaterial( { color: 0xdddddd, specular: 0x009900, shininess: 30, flatShading: true } ) );
        this.materials.push( new THREE.MeshNormalMaterial() );
        this.materials.push( new THREE.MeshBasicMaterial( { color: 0xffaa00, transparent: true, blending: THREE.AdditiveBlending } ) );
        this.materials.push( new THREE.MeshLambertMaterial( { color: 0xdddddd } ) );
        this.materials.push( new THREE.MeshPhongMaterial( { color: 0xdddddd, specular: 0x009900, shininess: 30, map: texture, transparent: true } ) );
        this.materials.push( new THREE.MeshNormalMaterial( { flatShading: true } ) );
        this.materials.push( new THREE.MeshBasicMaterial( { color: 0xffaa00, wireframe: true } ) );
        this.materials.push( new THREE.MeshDepthMaterial() );
        this.materials.push( new THREE.MeshLambertMaterial( { color: 0x666666, emissive: 0xff0000 } ) );
        this.materials.push( new THREE.MeshPhongMaterial( { color: 0x000000, specular: 0x666666, emissive: 0xff0000, shininess: 10, opacity: 0.9, transparent: true } ) );
        this.materials.push( new THREE.MeshBasicMaterial( { map: texture, transparent: true } ) );

        // Spheres geometry
        var geometry = new THREE.SphereBufferGeometry( 70, 32, 16 );
        for ( var i = 0, l = this.materials.length; i < l; i ++ ) {
          this.addMesh( geometry, this.materials[ i ] );
        }

        // Lights
        this.scene.add( new THREE.AmbientLight( 0x111111 ) );
        var directionalLight = new THREE.DirectionalLight( 0xffffff, 0.125 );
        directionalLight.position.x = Math.random() - 0.5;
        directionalLight.position.y = Math.random() - 0.5;
        directionalLight.position.z = Math.random() - 0.5;
        directionalLight.position.normalize();
        this.scene.add( directionalLight );
        this.pointLight = new THREE.PointLight( 0xffffff, 1 );
        this.scene.add( this.pointLight );

        window.addEventListener( 'resize', this.onWindowResize, false );
      },
      animate: function () {
        requestAnimationFrame(this.animate);
        this.controls.update();
        this.render();
      },
      addMesh: function ( geometry, material ) {
        var mesh = new THREE.Mesh( geometry, material );
        mesh.position.x = ( this.objects.length % 4 ) * 200 - 400;
        mesh.position.z = Math.floor( this.objects.length / 4 ) * 200 - 200;
        mesh.rotation.x = Math.random() * 200 - 100;
        mesh.rotation.y = Math.random() * 200 - 100;
        mesh.rotation.z = Math.random() * 200 - 100;
        this.objects.push( mesh );
        this.scene.add( mesh );
      },
      onWindowResize: function () {
        this.camera.aspect = this.width / this.height;
        this.camera.updateProjectionMatrix();
        this.renderer.setSize( this.width, this.height );
      },
      generateTexture: function () {
        var canvas = document.createElement( 'canvas' );
        canvas.width = 256;
        canvas.height = 256;
        var context = canvas.getContext( '2d' );
        var image = context.getImageData( 0, 0, 256, 256 );
        var x = 0, y = 0;
        for ( var i = 0, j = 0, l = image.data.length; i < l; i += 4, j ++ ) {
          x = j % 256;
          y = x == 0 ? y + 1 : y;
          image.data[ i ] = 255;
          image.data[ i + 1 ] = 255;
          image.data[ i + 2 ] = 255;
          image.data[ i + 3 ] = Math.floor( x ^ y );
        }
        context.putImageData( image, 0, 0 );
        return canvas;
      },
      render: function () {
        var timer = 0.0001 * Date.now();
        this.camera.position.x = Math.cos( timer ) * 1000;
        this.camera.position.z = Math.sin( timer ) * 1000;
        this.camera.lookAt( this.scene.position );
        for ( var i = 0, l = this.objects.length; i < l; i ++ ) {
          var object = this.objects[ i ];
          object.rotation.x += 0.01;
          object.rotation.y += 0.005;
        }
        this.materials[ this.materials.length - 2 ].emissive.setHSL( 0.54, 1, 0.35 * ( 0.5 + 0.5 * Math.sin( 35 * timer ) ) );
        this.materials[ this.materials.length - 3 ].emissive.setHSL( 0.04, 1, 0.35 * ( 0.5 + 0.5 * Math.cos( 35 * timer ) ) );
        this.pointLight.position.x = Math.sin( timer * 7 ) * 300;
        this.pointLight.position.y = Math.cos( timer * 5 ) * 400;
        this.pointLight.position.z = Math.cos( timer * 3 ) * 300;
        this.renderer.render( this.scene, this.camera );
      }
    },
    mounted() {
      this.init()
      this.animate()
    }
  }
</script>
