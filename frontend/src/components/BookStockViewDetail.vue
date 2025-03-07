<template>

    <v-card outlined>
        <v-card-title>
            BookStock # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="Stock" v-model="item.stock" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="BookId" v-model="item.bookId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Name" v-model="item.name" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Author" v-model="item.author" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'BookStockViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/bookStocks/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

