<template>

    <v-data-table
        :headers="headers"
        :items="bookStock"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'BookStockView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "stock", value: "stock" },
                { text: "bookId", value: "bookId" },
                { text: "name", value: "name" },
                { text: "author", value: "author" },
            ],
            bookStock : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/bookStocks'))

            temp.data._embedded.bookStocks.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.bookStock = temp.data._embedded.bookStocks;
        },
        methods: {
        }
    }
</script>

