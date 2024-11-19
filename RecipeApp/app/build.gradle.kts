

plugins {
    alias(libs.plugins.android.application)
    //alias(libs.plugins.kotlin.android)
    id ("org.jetbrains.kotlin.android")
  id("com.google.devtools.ksp")

}

android {
    namespace = "com.m1ctopt1.recipeapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.m1ctopt1.recipeapp"
        minSdk = 22
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //circle image view
        implementation(libs.circleimageview)
    //scalable unit text size
        implementation("com.intuit.ssp:ssp-android:1.1.1")
    //scalable unit size
        implementation ("com.intuit.sdp:sdp-android:1.1.1")
    //room database
        val room_version = "2.6.1"
        implementation("androidx.room:room-runtime:$room_version")
        ksp("androidx.room:room-compiler:$room_version")
        implementation("androidx.room:room-ktx:$room_version")
        testImplementation("androidx.room:room-testing:$room_version")
        implementation(libs.roundedimageview)
    //crop image library
        implementation("com.vanniktech:android-image-cropper:4.6.0")
    //easy permission
        implementation(libs.easypermissions)
    //coroutines core
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


}