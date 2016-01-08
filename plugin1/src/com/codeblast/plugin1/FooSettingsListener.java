package com.codeblast.plugin1;

import com.intellij.openapi.externalSystem.settings.ExternalSystemSettingsListener;
import com.intellij.util.messages.Topic;

public interface FooSettingsListener extends ExternalSystemSettingsListener<FooProjectSettings> {
    Topic<FooSettingsListener> TOPIC = Topic.create("Foo settings", FooSettingsListener.class);
}
