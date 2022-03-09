plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.learneng"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    viewBinding {
        android.buildFeatures.viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    //std lib
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //Base impl
    implementation(AppDependencies.baseImpl)

    //koin
    implementation(AppDependencies.diImpl)

    //retrofit
    implementation(AppDependencies.retrofitImpl)

    //Recycler View
    implementation(AppDependencies.recyclerViewImpl)

    //design
    implementation(AppDependencies.designImpl)

    //room
    implementation(AppDependencies.roomImpl)

    //kapt
    kapt(AppDependencies.kapt)

    //coroutines
    implementation(AppDependencies.coroutinesImpl)


    //test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
}