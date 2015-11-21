/*
 * Copyright (c) 2015-2015 Vladimir Schneider <vladimir.schneider@gmail.com>, all rights reserved.
 *
 * This code is private property of the copyright holder and cannot be used without
 * having obtained a license or prior written permission of the of the copyright holder.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package com.vladsch.idea.multimarkdown.util

import com.intellij.openapi.project.Project

abstract class LinkResolver(val project: Project?, val containingFile: FileRef) {
    companion object {
        val ONLY_LOCAL = 1
        val ONLY_EXTERNAL = 2
        val LOOSE_MATCH = 4

        fun wantLocal(options: Int): Boolean = (options and ONLY_EXTERNAL == 0) || (options and ONLY_LOCAL != 0)
        fun wantExternal(options: Int): Boolean = (options and ONLY_LOCAL == 0) || (options and ONLY_EXTERNAL != 0)
        fun wantLooseMatch(options: Int): Boolean = (options and LOOSE_MATCH != 0)
        fun wantSome(options: Int, flags: Int): Boolean = (options and flags != 0)
        fun wantAll(options: Int, flags: Int): Boolean = (options and flags == flags)
    }

    abstract fun resolve(linkRef: LinkRef, options: Int = 0, inList: List<FileRef>? = null): LinkInfo?;
    abstract fun isResolved(linkRef: LinkRef, options: Int = 0, inList: List<FileRef>? = null): Boolean;
    abstract fun multiResolve(linkRef: LinkRef, options: Int = 0, inList: List<FileRef>? = null): List<LinkInfo>;
    abstract fun isResolvedTo(linkRef: LinkRef, targetRef: FileRef, options: Int = 0): Boolean;
    abstract fun analyze(linkRef: LinkRef, targetRef: FileRef): MismatchReasons;
}