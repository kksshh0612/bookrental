
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import BookBookManager from "./components/listers/BookBookCards"
import BookBookDetail from "./components/listers/BookBookDetail"

import BookStockView from "./components/BookStockView"
import BookStockViewDetail from "./components/BookStockViewDetail"
import UserUserManager from "./components/listers/UserUserCards"
import UserUserDetail from "./components/listers/UserUserDetail"

import ReservationReservationManager from "./components/listers/ReservationReservationCards"
import ReservationReservationDetail from "./components/listers/ReservationReservationDetail"

import NotificationNotificationManager from "./components/listers/NotificationNotificationCards"
import NotificationNotificationDetail from "./components/listers/NotificationNotificationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/books/books',
                name: 'BookBookManager',
                component: BookBookManager
            },
            {
                path: '/books/books/:id',
                name: 'BookBookDetail',
                component: BookBookDetail
            },

            {
                path: '/books/bookStocks',
                name: 'BookStockView',
                component: BookStockView
            },
            {
                path: '/books/bookStocks/:id',
                name: 'BookStockViewDetail',
                component: BookStockViewDetail
            },
            {
                path: '/users/users',
                name: 'UserUserManager',
                component: UserUserManager
            },
            {
                path: '/users/users/:id',
                name: 'UserUserDetail',
                component: UserUserDetail
            },

            {
                path: '/reservations/reservations',
                name: 'ReservationReservationManager',
                component: ReservationReservationManager
            },
            {
                path: '/reservations/reservations/:id',
                name: 'ReservationReservationDetail',
                component: ReservationReservationDetail
            },

            {
                path: '/notifications/notifications',
                name: 'NotificationNotificationManager',
                component: NotificationNotificationManager
            },
            {
                path: '/notifications/notifications/:id',
                name: 'NotificationNotificationDetail',
                component: NotificationNotificationDetail
            },



    ]
})
