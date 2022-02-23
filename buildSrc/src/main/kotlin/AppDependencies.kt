object AppDependencies {
    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitJsonAdapter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val retrofitInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofitCoroutinesAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesAdapter}"


    //adapter
    const val fastAdapter = "com.mikepenz:fastadapter:${Versions.fastAdapter}"
    const val fastAdapterBinding =
        "com.mikepenz:fastadapter-extensions-binding:${Versions.fastAdapterExtension}"
    const val fastAdapterDiff =
        "com.mikepenz:fastadapter-extensions-diff:${Versions.fastAdapterExtension}"


    const val kotlinKtx = "androidx.core:core-ktx:${Versions.kotlinKtx}"


    const val coreKoin = "io.insert-koin:koin-core:${Versions.koin}"
    const val androidKoin = "io.insert-koin:koin-android:${Versions.koin}"
    const val compat = "io.insert-koin:koin-android:${Versions.koin}"


    const val coreCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val androidCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"


    const val coil = "io.coil-kt:coil:${Versions.coil}"


    const val runtimeRoom = "androidx.room:room-runtime:${Versions.runtime}"
    const val compilerRoom = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val roomKtxRoom = "androidx.room:room-ktx:${Versions.roomKtx}"


    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"


    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"


    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    const val support = "androidx.legacy:legacy-support-v4:${Versions.support}"

    val baseImpl = arrayListOf(
        viewModelKtx,
        kotlinKtx,
        support,
        coil
    )


    val diImpl = arrayListOf(
        coreKoin,
        androidKoin,
        compat
    )

    val retrofitImpl = arrayListOf(
        retrofit,
        retrofitJsonAdapter,
        retrofitInterceptor,
        retrofitCoroutinesAdapter
    )

    val recyclerViewImpl = arrayListOf(
        fastAdapter,
        fastAdapterBinding,
        fastAdapterDiff
    )

    val designImpl = arrayListOf(
        appcompat,
        material,
        constraint
    )

    val roomImpl = arrayListOf(
        runtimeRoom,
        roomKtxRoom
    )

    val kapt = arrayListOf(
        compilerRoom
    )

    val coroutinesImpl = arrayListOf(
        coreCoroutines,
        androidCoroutines,
    )

    val androidTestLibraries = arrayListOf(espresso, extJunit)

    val testLibraries = arrayListOf(junit)
}
