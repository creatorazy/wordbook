import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Reg from '../views/Reg.vue'
import Add from '../views/Add.vue'
import Up from '../views/Up.vue'
import UpPwd from '../views/UpPwd.vue'

Vue.use(VueRouter)

const routes = [{
		path: '/login',
		name: 'Login',
		component: Login
	}, {
		path: '/reg',
		name: 'reg',
		component: Reg
	}, {
		path: '/add',
		name: 'add',
		component: Add
	}, {
		path: '/up',
		name: 'up',
		component: Up
	}, {
		path: '/upPwd',
		name: 'upPwd',
		component: UpPwd
	},
	{
		path: '/',
		name: 'index',
		// route level code-splitting
		// this generates a separate chunk (about.[hash].js) for this route
		// which is lazy-loaded when the route is visited.
		component: () => import( /* webpackChunkName: "about" */ '../views/Index.vue')
	},
	{
		path: '/*',
		redirect: '/login'
	}
]

const router = new VueRouter({
	mode: 'history',
	routes
})

router.beforeEach((to, from, next) => {
	if (to.path === '/login') {
		if (sessionStorage.getItem('id') != null) {
			next(from.path);
		} else {
			next();
			return;
		}
	}

	if (to.path === '/up') {
		if (sessionStorage.getItem('word') == null || sessionStorage.getItem('id') == null) {
			next(from.path);
		} else {
			next();
			return;
		}
	}

	if (sessionStorage.getItem("id") != null) {
		next();
	} else if (to.path != '/reg') {
		next('/login')
	} else {
		next();
	}
})

export default router
