import axios from 'axios';

// const shopsApi = axios.create({
//     baseURL: "http://localhost:8080"
// })

export default {

    getShopsList() {
        return axios.get('/shops');
    },
    getAdminShopsList() {
        return axios.get('/admin');
    },
    getShopById(id) {
        return axios.get(`/details${id}`)
    },
    getFavoritesList() {
        return axios.get('/favorites')
    },
    addFavorite(shopId) {
        return axios.post(`/favorites/${shopId}`, shopId)
    },
    unFavorite(shopId){
        return axios.delete(`/favorites/${shopId}`)
    },
    addVisited(shopId) {
        return axios.post(`/visited/${shopId}`, shopId)
    },
    removeVisited(shopId) {
        return axios.delete(`/visited/${shopId}`)
    },
    getVisitedList() {
        return axios.get('/visited')
    },
    addNewShop(shop) {
        // const url = '/addshops';
        // return shopsApi.post(url, shop)
        return axios.post('/addshops', shop)
    },
    approved(shopId) {
        return axios.put(`/approved/${shopId}`)
    },
    unApproved(shopId) {
        return axios.put(`/unapproved/${shopId}`)
    },
    deleteShop(shopId) {
        return axios.delete(`/delete/${shopId}`)
    }
}