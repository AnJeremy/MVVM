package com.chenxuan.net;

import com.chenxuan.common.base.BaseResponse;
import com.chenxuan.common.base.BaseResponseCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author cx
 */
final class CxResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CxResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        BaseResponse baseResponse = gson.fromJson(response, BaseResponse.class);
        if (baseResponse.getErrorCode() != BaseResponseCode.SUCCESS) {
            value.close();
            throw new ApiException(baseResponse.getErrorCode(), baseResponse.getErrorMsg());
        }
        try {
            return adapter.fromJson(response);
        } finally {
            value.close();
        }
    }
}
