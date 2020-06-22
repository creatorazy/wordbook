import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from "axios"
import jquery from "jquery"
import '@vant/touch-emulator';
import { Button, Col, Row , Form , Field , Toast , NavBar , Icon , PullRefresh , SwipeCell , List , Popup , Cell ,Image as VanImage ,Dialog } from 'vant'
import 'vant/lib/index.less'
Vue.use(Button).use(Col).use(Row).use(Form).use(Field).use(Toast).use(NavBar).use(Icon).use(PullRefresh);
Vue.use(SwipeCell).use(List).use(Popup).use(Cell).use(VanImage).use(Dialog)
Vue.prototype.$ = jquery;
Vue.prototype.$axios = axios;
Vue.config.productionTip = false
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
