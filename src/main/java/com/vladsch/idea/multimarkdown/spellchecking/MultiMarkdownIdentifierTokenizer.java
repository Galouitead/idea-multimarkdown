/*
 * Copyright 2000-2011 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vladsch.idea.multimarkdown.spellchecking;

import com.intellij.psi.PsiIdentifier;
import com.intellij.spellchecker.inspections.IdentifierSplitter;
import com.intellij.spellchecker.tokenizer.TokenConsumer;
import com.intellij.spellchecker.tokenizer.Tokenizer;
import com.vladsch.idea.multimarkdown.psi.MultiMarkdownNamedElement;
import org.jetbrains.annotations.NotNull;

/**
 * @author yole
 */
public class MultiMarkdownIdentifierTokenizer extends Tokenizer<MultiMarkdownNamedElement> {
    @Override
    public void tokenize(@NotNull MultiMarkdownNamedElement element, TokenConsumer consumer) {
        consumer.consumeToken(element, true, IdentifierSplitter.getInstance());
    }
}
