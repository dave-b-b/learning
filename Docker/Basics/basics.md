# Docker Basics

When creating a Docker container, one should think about how one would build an application from the beginning. The conventient things about Docker is that you can pull down images that essentially create a shell for you to you (similar) to using a template from someone else. E.g.

```
FROM hello-world:latest
```

Inside of this container are the following commands:

`COPY hello / # buildkit`

`CMD ["/hello"]`

What these two commands do is:
1. Copy the hello into the root directory (/)
2. Run the hello command

This would be the equivalent of me copying the file in my command line, then running the file by putting its name in the terminal
