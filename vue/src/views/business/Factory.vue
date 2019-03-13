<template>
  <div id="container"></div>
</template>

<script>
  import * as THREE from 'three'
  import TrackballControls from '@/api/TrackballControls.js'
  import layer1 from '@/images/layer1.svg'
  import layer2 from '@/images/layer2.svg'
  import layer3 from '@/images/layer3.svg'
  import layer4 from '@/images/layer4.svg'
  import layer5 from '@/images/layer5.svg'
  import layer6 from '@/images/layer6.svg'
  import layer7 from '@/images/layer7.svg'
  import layerOHC from '@/images/layer-OHC.svg'
  import layerAUTOTAPE from '@/images/layer-AUTO-TAPE.svg'
  export default {
    name: "factory",
    data () {
      return {
        camera: null,
        scene: null,
        renderer: null,
        helper: null,
        materials: [],
        meshs: [],
        geometries: [],
        controls: null,
        qiu: null,
        width: window.innerWidth - 50,
        height: window.innerHeight - 100
      }
    },
    methods: {
      onWindowResize() {
        this.width = window.innerWidth - 50;
        this.height = window.innerHeight - 100;
        this.camera.aspect = this.width/this.height;
        this.camera.updateProjectionMatrix();
        this.renderer.setSize( this.width, this.height );
        this.controls.handleResize();
      },
      init: function () {
        let container = document.getElementById('container');
        this.renderer = new THREE.WebGLRenderer({antialias: true});
        this.renderer.setSize(this.width, this.height);
        this.renderer.setClearColor(0xffffff);
        container.appendChild(this.renderer.domElement);

        this.camera = new THREE.PerspectiveCamera(55, this.width/this.height, 0.1, 1000);
        this.camera.position.set(30,25,0);
        this.camera.lookAt(new THREE.Vector3(0, 0, 0));

        this.controls = new TrackballControls( this.camera, this.renderer.domElement );
        this.controls.rotateSpeed = 5.0;
        this.controls.zoomSpeed = 5;
        this.controls.panSpeed = 2;
        this.controls.noZoom = false;
        this.controls.noPan = false;
        this.controls.staticMoving = false;
        this.controls.dynamicDampingFactor = 0.3;

        this.scene = new THREE.Scene();
        this.scene.add(this.camera);

        // var helper = new THREE.GridHelper( 70, 50 , 0x0000ff, 0x808080);
        // this.scene.add( helper );

        var geometry = new THREE.PlaneGeometry( 50, 60, 32 );
        var material = new THREE.MeshBasicMaterial( {color: 0xeeeeee, side: THREE.DoubleSide} );
        var plane = new THREE.Mesh( geometry, material );
        plane.rotation.x = Math.PI/2;
        plane.position.y = -0.5;
        this.scene.add( plane );

        for(let i=-5; i<6; i++){
          for(let j=-5; j<5; j++){
            let geometry =  new THREE.BoxGeometry(1, 1, 4);
            let material
            if ( j === -5) {
              let texture = new THREE.TextureLoader().load(layer1);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            }  else if ( j === -4 ) {
              let texture = new THREE.TextureLoader().load(layer3);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            } else if ( j === -3 ) {
              let texture = new THREE.TextureLoader().load(layer4);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            } else if ( j === -2 ) {
              let texture = new THREE.TextureLoader().load(layer6);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            } else if ( j === -1 ) {
              let texture = new THREE.TextureLoader().load(layer4);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            } else if ( j === 0 ) {
              let texture = new THREE.TextureLoader().load(layer5);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            } else if ( j === 1 ) {
              let texture = new THREE.TextureLoader().load(layer2);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            } else if ( j === 2 ) {
              let texture = new THREE.TextureLoader().load(layerAUTOTAPE);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            } else if ( j === 3 ) {
              let texture = new THREE.TextureLoader().load(layer1);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            } else if ( j === 4 ) {
              let texture = new THREE.TextureLoader().load(layerOHC);
              material = new THREE.MeshLambertMaterial( { map: texture } );
            }
            // else if(i===3 && j===0){
            //   material = new THREE.MeshLambertMaterial( { color: 0xff0000 } );
            // }
            // else{
            //   material = new THREE.MeshLambertMaterial( { color: 0x666666 } );
            // }

            let mesh = new THREE.Mesh(geometry, material);

            mesh.position.x = i*3;
            mesh.position.z = j*5;
            this.geometries.push(geometry);
            this.materials.push(material);
            this.meshs.push(mesh);
            this.scene.add(mesh);

            // if(i===0 && j===0){
            //   var faces = this.geometries[0].faces;
            //   for (let k = 0; k <faces.length; k++) {
            //     faces[k].color.setHex( 0xff0000 );
            //     //faces[k].color.setRGB( Math.random(), Math.random(), Math.random() );
            //   }
            // }

            if(i===2 && j===2){
              this.materials[0].color.setHex(0xffff00);
              this.materials[10].color.setHex(0x00ff00);
              this.materials[55].color.setHex(0xff0000);
            }
          }
        }

        geometry =  new THREE.SphereBufferGeometry( 0.3, 132, 116 );
        material = new THREE.MeshBasicMaterial( {color: 0x222222} );
        this.qiu = new THREE.Mesh( geometry, material );
        this.qiu.position.x = 10.5;
        this.qiu.position.y = 0;
        this.qiu.position.z = 20;
        this.scene.add( this.qiu );

        // Lights
        this.scene.add( new THREE.AmbientLight( 0xffffff ) );
        var directionalLight = new THREE.DirectionalLight( 0xffffff, 0.125 );
        directionalLight.position.x = Math.random() * 10 - 5;
        directionalLight.position.y = Math.random() * 10 - 5;
        directionalLight.position.z = Math.random() * 10 - 5;
        directionalLight.position.normalize();
        this.scene.add( directionalLight );
        this.pointLight = new THREE.PointLight( 0xffffff, 1 );
        this.pointLight.position.y = 40;
        this.scene.add( this.pointLight );

        window.addEventListener( 'resize', this.onWindowResize, false );
      },
      animate: function () {
        requestAnimationFrame(this.animate);
        if(this.qiu.position.z >= 2.5 && this.qiu.position.x == 10.5){
          this.qiu.position.z -= 0.1;
        }
        if(this.qiu.position.z < 2.5 && this.qiu.position.x >= 1.5){
          this.qiu.position.x -= 0.1;
        }
        if(this.qiu.position.x < 1.5 && this.qiu.position.z >= -22.5 ){
          this.qiu.position.z -= 0.1;
        }
        if(this.qiu.position.z.toFixed(2) == -22.5){
          this.qiu.position.x = 10.5;
          this.qiu.position.y = 0;
          this.qiu.position.z = 20;
        }
        this.controls.update();
        this.renderer.render(this.scene, this.camera);
      }
    },
    mounted () {
      this.init()
      this.animate()
    }
  }
</script>

<style scoped>

</style>
