<template>

    <v-data-table
        :headers="headers"
        :items="bookDashboard"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'BookDashboardView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "bookName", value: "bookName" },
                { text: "rentalStatus", value: "rentalStatus" },
            ],
            bookDashboard : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/bookDashboards'))

            temp.data._embedded.bookDashboards.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.bookDashboard = temp.data._embedded.bookDashboards;
        },
        methods: {
        }
    }
</script>

