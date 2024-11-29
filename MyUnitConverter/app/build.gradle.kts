import com.android.build.gradle.internal.dsl.decorator.SupportedPropertyType.Collection.List.type

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.m1ctopt1.myunitconverter"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.m1ctopt1.myunitconverter"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("junit:junit:4.12")
    //testImplementation(libs.junit)
   // testImplementation(libs.junit.jupiter)
   // testImplementation(libs.junit.jupiter)
   // testImplementation(libs.junit.jupiter)
   // testImplementation(libs.junit.jupiter)
   // testImplementation(libs.junit.jupiter)
   // androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}