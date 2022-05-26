cmake_minimum_required(VERSION 3.10.2)
project("nativecompose")


add_library(
        nativecompose
        SHARED
        native-lib.cpp
        )


find_library(
        log-lib
        log
        )


target_link_libraries(
        nativecompose
        ${log-lib}
        )