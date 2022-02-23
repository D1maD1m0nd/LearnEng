

object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitJsonAdapter = "com.squareup.retrofit2:${Versions.retrofit}"
    const val retrofitInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val retrofitCoroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutinesAdapter}"
}

object Adapter {
    const val fastAdapter = "com.mikepenz:fastadapter:${Versions.fastAdapter}"
    const val fastAdapterBinding = "com.mikepenz:fastadapter-extensions-binding:${Versions.fastAdapterExtension}"
    const val fastAdapterDiff = "com.mikepenz:fastadapter-extensions-diff:${Versions.fastAdapterExtension}"
}

object Kotlin {
    const val kotlinKtx = "androidx.core:core-ktx:${Versions.kotlinKtx}"
}

object Koin {
    const val core = "io.insert-koin:koin-core:${Versions.koin}"
    const val android = "io.insert-koin:koin-android:${Versions.koin}"
    const val compat = "io.insert-koin:koin-android:${Versions.koin}"
}

object Coroutines {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
}

object Coil {
    const val coil = "implementation 'io.coil-kt:coil:${Versions.coil}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.runtime}"
    const val compiler = "androidx.room:room-compiler:${Versions.roomCompiler}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.roomKtx}"
}

object Design {
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
}

object Lifecycle {
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
}

object TestImpl {
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object Support {
    const val support = "androidx.legacy:legacy-support-v4:${Versions.support}"
}