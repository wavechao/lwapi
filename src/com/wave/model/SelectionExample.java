package com.wave.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSelectionidIsNull() {
            addCriterion("selectionid is null");
            return (Criteria) this;
        }

        public Criteria andSelectionidIsNotNull() {
            addCriterion("selectionid is not null");
            return (Criteria) this;
        }

        public Criteria andSelectionidEqualTo(Integer value) {
            addCriterion("selectionid =", value, "selectionid");
            return (Criteria) this;
        }

        public Criteria andSelectionidNotEqualTo(Integer value) {
            addCriterion("selectionid <>", value, "selectionid");
            return (Criteria) this;
        }

        public Criteria andSelectionidGreaterThan(Integer value) {
            addCriterion("selectionid >", value, "selectionid");
            return (Criteria) this;
        }

        public Criteria andSelectionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("selectionid >=", value, "selectionid");
            return (Criteria) this;
        }

        public Criteria andSelectionidLessThan(Integer value) {
            addCriterion("selectionid <", value, "selectionid");
            return (Criteria) this;
        }

        public Criteria andSelectionidLessThanOrEqualTo(Integer value) {
            addCriterion("selectionid <=", value, "selectionid");
            return (Criteria) this;
        }

        public Criteria andSelectionidIn(List<Integer> values) {
            addCriterion("selectionid in", values, "selectionid");
            return (Criteria) this;
        }

        public Criteria andSelectionidNotIn(List<Integer> values) {
            addCriterion("selectionid not in", values, "selectionid");
            return (Criteria) this;
        }

        public Criteria andSelectionidBetween(Integer value1, Integer value2) {
            addCriterion("selectionid between", value1, value2, "selectionid");
            return (Criteria) this;
        }

        public Criteria andSelectionidNotBetween(Integer value1, Integer value2) {
            addCriterion("selectionid not between", value1, value2, "selectionid");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNull() {
            addCriterion("studentid is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentid is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("studentid =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("studentid <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("studentid >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("studentid >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("studentid <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("studentid <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("studentid in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("studentid not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("studentid between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("studentid not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andTitleidIsNull() {
            addCriterion("titleid is null");
            return (Criteria) this;
        }

        public Criteria andTitleidIsNotNull() {
            addCriterion("titleid is not null");
            return (Criteria) this;
        }

        public Criteria andTitleidEqualTo(Integer value) {
            addCriterion("titleid =", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidNotEqualTo(Integer value) {
            addCriterion("titleid <>", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidGreaterThan(Integer value) {
            addCriterion("titleid >", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("titleid >=", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidLessThan(Integer value) {
            addCriterion("titleid <", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidLessThanOrEqualTo(Integer value) {
            addCriterion("titleid <=", value, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidIn(List<Integer> values) {
            addCriterion("titleid in", values, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidNotIn(List<Integer> values) {
            addCriterion("titleid not in", values, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidBetween(Integer value1, Integer value2) {
            addCriterion("titleid between", value1, value2, "titleid");
            return (Criteria) this;
        }

        public Criteria andTitleidNotBetween(Integer value1, Integer value2) {
            addCriterion("titleid not between", value1, value2, "titleid");
            return (Criteria) this;
        }

        public Criteria andArticleScoreIsNull() {
            addCriterion("article_score is null");
            return (Criteria) this;
        }

        public Criteria andArticleScoreIsNotNull() {
            addCriterion("article_score is not null");
            return (Criteria) this;
        }

        public Criteria andArticleScoreEqualTo(Byte value) {
            addCriterion("article_score =", value, "articleScore");
            return (Criteria) this;
        }

        public Criteria andArticleScoreNotEqualTo(Byte value) {
            addCriterion("article_score <>", value, "articleScore");
            return (Criteria) this;
        }

        public Criteria andArticleScoreGreaterThan(Byte value) {
            addCriterion("article_score >", value, "articleScore");
            return (Criteria) this;
        }

        public Criteria andArticleScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("article_score >=", value, "articleScore");
            return (Criteria) this;
        }

        public Criteria andArticleScoreLessThan(Byte value) {
            addCriterion("article_score <", value, "articleScore");
            return (Criteria) this;
        }

        public Criteria andArticleScoreLessThanOrEqualTo(Byte value) {
            addCriterion("article_score <=", value, "articleScore");
            return (Criteria) this;
        }

        public Criteria andArticleScoreIn(List<Byte> values) {
            addCriterion("article_score in", values, "articleScore");
            return (Criteria) this;
        }

        public Criteria andArticleScoreNotIn(List<Byte> values) {
            addCriterion("article_score not in", values, "articleScore");
            return (Criteria) this;
        }

        public Criteria andArticleScoreBetween(Byte value1, Byte value2) {
            addCriterion("article_score between", value1, value2, "articleScore");
            return (Criteria) this;
        }

        public Criteria andArticleScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("article_score not between", value1, value2, "articleScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreIsNull() {
            addCriterion("oral_score is null");
            return (Criteria) this;
        }

        public Criteria andOralScoreIsNotNull() {
            addCriterion("oral_score is not null");
            return (Criteria) this;
        }

        public Criteria andOralScoreEqualTo(Byte value) {
            addCriterion("oral_score =", value, "oralScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreNotEqualTo(Byte value) {
            addCriterion("oral_score <>", value, "oralScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreGreaterThan(Byte value) {
            addCriterion("oral_score >", value, "oralScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("oral_score >=", value, "oralScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreLessThan(Byte value) {
            addCriterion("oral_score <", value, "oralScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreLessThanOrEqualTo(Byte value) {
            addCriterion("oral_score <=", value, "oralScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreIn(List<Byte> values) {
            addCriterion("oral_score in", values, "oralScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreNotIn(List<Byte> values) {
            addCriterion("oral_score not in", values, "oralScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreBetween(Byte value1, Byte value2) {
            addCriterion("oral_score between", value1, value2, "oralScore");
            return (Criteria) this;
        }

        public Criteria andOralScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("oral_score not between", value1, value2, "oralScore");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}