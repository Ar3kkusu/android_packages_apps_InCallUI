/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.android.incallui;

/**
 *
 */
public class AnswerPresenter {

    private Ui mUi;
    private Listener mListener;

    public AnswerPresenter(Ui ui, Listener listener) {
        this.mUi = ui;
        this.mListener = listener;

        mUi.setPresenter(this);
    }

    public void onAnswer() {
        // TODO(klp): hook in call id.
        CallHandlerService.answerCall(1);
        mListener.onAnswered();
    }

    public void onDecline() {
        mListener.onAnswered();
    }

    public void onText() {
        mListener.onAnswered();
    }

    public interface Ui {
        void setPresenter(AnswerPresenter presenter);
    }

    public interface Listener {
        void onAnswered();
    }
}