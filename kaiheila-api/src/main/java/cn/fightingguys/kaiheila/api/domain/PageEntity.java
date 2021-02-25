/*
 *    Copyright 2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package cn.fightingguys.kaiheila.api.domain;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Pageable 实体替换
 *
 * @param <T> 实体数据
 */
public class PageEntity<T> {

    private List<T> items;

    private PageMeta meta;

    private PageSort sort;

    public PageEntity() {
    }

    public List<T> getItems() {
        return items;
    }

    public PageMeta getMeta() {
        return meta;
    }

    public PageSort getSort() {
        return sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageEntity<?> that = (PageEntity<?>) o;
        return Objects.equals(items, that.items) && Objects.equals(meta, that.meta) && Objects.equals(sort, that.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, meta, sort);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PageEntity.class.getSimpleName() + "[", "]")
                .add("items=" + items)
                .add("meta=" + meta)
                .add("sort=" + sort)
                .toString();
    }

    static class PageMeta {
        private int page;
        private int pageTotal;
        private int pageSize;
        private int total;

        public PageMeta() {
        }

        public int getPage() {
            return page;
        }

        public int getPageTotal() {
            return pageTotal;
        }

        public int getPageSize() {
            return pageSize;
        }

        public int getTotal() {
            return total;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PageMeta pageMeta = (PageMeta) o;
            return page == pageMeta.page && pageTotal == pageMeta.pageTotal && pageSize == pageMeta.pageSize && total == pageMeta.total;
        }

        @Override
        public int hashCode() {
            return Objects.hash(page, pageTotal, pageSize, total);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", PageMeta.class.getSimpleName() + "[", "]")
                    .add("page=" + page)
                    .add("pageTotal=" + pageTotal)
                    .add("pageSize=" + pageSize)
                    .add("total=" + total)
                    .toString();
        }
    }

    static class PageSort {
        private int id;

        public PageSort() {
        }

        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PageSort pageSort = (PageSort) o;
            return id == pageSort.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", PageSort.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .toString();
        }
    }
}
