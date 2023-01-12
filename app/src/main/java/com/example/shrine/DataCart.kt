package com.example.shrine

data class CartDataItem(
    val id: Int,
    val title: String,
    val price: Int,
    val vendor: Vendor,
    val category: Category,
    val photoResId: Int
)

enum class Vendor {
    Alphi,
    Lmbrjk,
    Mal,
    Six,
    Squiggle
}

enum class Category {
    All,
    Accessories,
    Clothing,
    Home
}


val SampleItems = listOf(
    CartDataItem(
        id = 0,
        title = "Vagabond sack",
        price = 120,
        vendor = Vendor.Squiggle,
        category = Category.Accessories,
        photoResId = R.drawable.photo_0
    ),
    CartDataItem(
        id = 1,
        title = "Stella sunglasses",
        price = 58,
        vendor = Vendor.Mal,
        category = Category.Accessories,
        photoResId = R.drawable.photo_1
    ),
    CartDataItem(
        id = 2,
        title = "Whitney belt",
        price = 35,
        vendor = Vendor.Lmbrjk,
        category = Category.Accessories,
        photoResId = R.drawable.photo_2
    ),
    CartDataItem(
        id = 3,
        title = "Garden stand",
        price = 98,
        vendor = Vendor.Alphi,
        category = Category.Accessories,
        photoResId = R.drawable.photo_3
    ),
    CartDataItem(
        id = 4,
        title = "Strut earrings",
        price = 34,
        vendor = Vendor.Six,
        category = Category.Accessories,
        photoResId = R.drawable.photo_4
    ),
    CartDataItem(
        id = 5,
        title = "Varsity socks",
        price = 12,
        vendor = Vendor.Lmbrjk,
        category = Category.Accessories,
        photoResId = R.drawable.photo_5
    ),
    CartDataItem(
        id = 6,
        title = "Weave key ring",
        price = 16,
        vendor = Vendor.Six,
        category = Category.Accessories,
        photoResId = R.drawable.photo_6
    ),
    CartDataItem(
        id = 7,
        title = "Gatsby hat",
        price = 40,
        vendor = Vendor.Six,
        category = Category.Accessories,
        photoResId = R.drawable.photo_7
    ),
    CartDataItem(
        id = 8,
        title = "Shrug bag",
        price = 198,
        vendor = Vendor.Squiggle,
        category = Category.Accessories,
        photoResId = R.drawable.photo_8
    ),
    CartDataItem(
        id = 9,
        title = "Gilt desk trio",
        price = 58,
        vendor = Vendor.Alphi,
        category = Category.Home,
        photoResId = R.drawable.photo_9
    ),
    CartDataItem(
        id = 10,
        title = "Copper wire rack",
        price = 18,
        vendor = Vendor.Alphi,
        category = Category.Home,
        photoResId = R.drawable.photo_10
    )
)