<template>
    <v-container fluid grid-list-md>
        <v-layout row wrap>
            <v-textarea box name="input-7-4" label="Box textarea" v-model="contextData.context"></v-textarea>
        </v-layout>
    </v-container>
</template>

<script>
export default {
  data() {
    return {
      contextData: this.$store.state.cards[this.$route.params.index]
    };
  }
};
</script>
