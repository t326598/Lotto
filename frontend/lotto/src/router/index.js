import {createRouter, createWebHistory} from 'vue-router';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: () => import('')
    },
    {
        path: 'lotto',
        name: 'LottoRecommend',
        component: () => import('@/views/LottoRecommendView.vue'),
    },
    {
        path: 'stats',
        name: 'LottoDetail',
        component: () => import('@/views/LottoDetailView.vue'),
    },
    {
        path: '/history/:round',
        name: 'LottoDetail',
        component: () => import('@/views/LottoDetailView.vue'),
    },
    {
        path: '/about',
        name: 'About',
        component: () => import('@/views/AboutView.vue'),
    },
    {
        path: '/:catchAll(.*)',
        redirect: '/',
    }
 ]

 const router = createRouter({
    history: createWebHistory(),
    routes,
 })

 export default router