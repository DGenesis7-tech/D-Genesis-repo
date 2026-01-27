import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const productApi = createApi({
    reducerPath: 'productGApi',  // 
    baseQuery: fetchBaseQuery({ baseUrl: 'https://genesisstore.com/api/' }), 
    endpoints: (builder) => ({
        getAllProducts: builder.query({
            query: () => 'products',  
        }),
    }),
});


export const { useGetAllProductsQuery } = productApi;
